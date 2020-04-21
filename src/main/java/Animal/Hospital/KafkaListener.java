package Animal.Hospital;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class KafkaListener {

    @Autowired
    FinancialManagementRepository financialManagementRepository;

    @StreamListener(Processor.INPUT)
    public void TreatedEvent(@Payload Treated reservationReserved) {
        if(reservationReserved.getEventType().equals("Treated")) {
            System.out.println("수납요청 되었습니다.");

            FinancialManagement financialManagement = new FinancialManagement();
            financialManagement.setReservationId(reservationReserved.getReservationId());
            financialManagement.setFee(10000L);
            financialManagementRepository.save(financialManagement);
        }
    }

//    @StreamListener(Processor.INPUT)
//    public void onReservationChangedEvent(@Payload ReservationChanged reservationChanged) {
//        if(reservationChanged.getEventType().equals("ReservationChanged")) {
//            System.out.println("예약 변경 되었습니다.");
//            ObjectMapper objectMapper = new ObjectMapper();
//            String json = null;
//            try {
//                json = objectMapper.writeValueAsString(new SmsMessage(reservationChanged.getPhoneNumber(),"예약 변경 되었습니다.."));
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException("JSON format exception", e);
//            }
//
//            Processor processor = NoticeApplication.applicationContext.getBean(Processor.class);
//            MessageChannel outputChannel = processor.output();
//            outputChannel.send(MessageBuilder.withPayload(json).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
//        }
//    }

//    @StreamListener(Processor.INPUT)
//    public void onReservationCanceledEvent(@Payload ReservationCanceled reservationCanceled) {
//        if(reservationCanceled.getEventType().equals("ReservationCanceled")) {
//            System.out.println("예약 취소 되었습니다.");
//            ObjectMapper objectMapper = new ObjectMapper();
//            String json = null;
//            try {
//                json = objectMapper.writeValueAsString(new SmsMessage(reservationCanceled.getPhoneNumber(),"예약 취소 되었습니다.."));
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException("JSON format exception", e);
//            }
//
//            Processor processor = NoticeApplication.applicationContext.getBean(Processor.class);
//            MessageChannel outputChannel = processor.output();
//            outputChannel.send(MessageBuilder.withPayload(json).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
//        }
//    }
}
