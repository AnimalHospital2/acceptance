package Animal.Hospital;

public class TreatmentFeeAccepted extends AbstractEvent {

    private Long id;
    private Long reservationId;
    private Long fee;
    private String eventType;

    @Override
    public String getEventType() {
        return eventType;
    }

    @Override
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public TreatmentFeeAccepted(Long reservationId, Long fee){
        super();
        this.reservationId = reservationId;
        this.fee = fee;
        this.eventType  = TreatmentFeeAccepted.class.getSimpleName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
