package Tshop;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Assignment")
public class Assignment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long assignmentId;
    private Long reservationId;
    private Long productId;
    private String agencyName;

    @PostPersist
    public void onPostPersist(){
        ReservationAccepted reservationAccepted = new ReservationAccepted();
        BeanUtils.copyProperties(this, reservationAccepted);
        reservationAccepted.publishAfterCommit();
    }
    @PostRemove
    public void onPostRemove(){
        ReservationCanceled reservationCanceled = new ReservationCanceled();
        BeanUtils.copyProperties(this, reservationCanceled);
        reservationCanceled.publishAfterCommit();
    }

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }
    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }





}
