package Animal.Hospital;

public class TreatmentFeeAccepted extends AbstractEvent {

    private Long reservationId;
    private Long fee;

    public TreatmentFeeAccepted(Long reservationId, Long fee){
        super();
        this.reservationId = reservationId;
        this.fee = fee;
    }



    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

}
