package Animal.Hospital;

public class TreatmentFeeAccepted extends AbstractEvent {

    private Long id;
    private Long reservationId;
    private Long fee;

    public TreatmentFeeAccepted(Long reservationId, Long fee){
        super();
        this.reservationId = reservationId;
        this.fee = fee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
