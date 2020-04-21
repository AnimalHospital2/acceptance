package Animal.Hospital;

public class TreatmentFee extends AbstractEvent {

    private Long id;

    public TreatmentFee(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
