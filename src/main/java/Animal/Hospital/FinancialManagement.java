package Animal.Hospital;

import javax.persistence.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

import java.util.List;

@Entity
@Table(name="FinancialManagement_table")
public class FinancialManagement {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long reservationId;
    private Long fee;


    @PostPersist
    public void publishTreatmentAcceptedEvent() {

//        MedicalRecord medicalRecord = new MedicalRecord();
//
//        medicalRecord.setReservationId(this.getId());
//        medicalRecord.setDoctor("Brad pitt");
//        medicalRecord.setMedicalOpinion("별 이상 없습니다.");
//        medicalRecord.setTreatment("그냥 집에서 푹 쉬면 나을 것입니다.");
//
//        ReservationApplication.applicationContext.getBean(MedicalRecordService.class).diagnosis(medicalRecord);
//

        // Reserved 이벤트 발생

        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;

        try {
            json = objectMapper.writeValueAsString(new TreatmentFeeAccepted(this.reservationId, 10000L));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON format exception", e);
        }

        Processor processor = Application.applicationContext.getBean(Processor.class);
        MessageChannel outputChannel = processor.output();

        outputChannel.send(MessageBuilder
                .withPayload(json)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
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
