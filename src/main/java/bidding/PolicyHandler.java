package bidding;

import bidding.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired BiddingParticipationRepository biddingParticipationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverNoticeCanceled_CancelBiddingParticipation(@Payload NoticeCanceled noticeCanceled){

        if(!noticeCanceled.validate()) return;

        System.out.println("\n\n##### listener CancelBiddingParticipation : " + noticeCanceled.toJson() + "\n\n");

        // Sample Logic //
        BiddingParticipation biddingParticipation = new BiddingParticipation();
        biddingParticipationRepository.save(biddingParticipation);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverNoticeRegistered_RecieveBiddingNotice(@Payload NoticeRegistered noticeRegistered){

        if(!noticeRegistered.validate()) return;

        System.out.println("\n\n##### listener RecieveBiddingNotice : " + noticeRegistered.toJson() + "\n\n");

        // Sample Logic //
        BiddingParticipation biddingParticipation = new BiddingParticipation();
        biddingParticipationRepository.save(biddingParticipation);
            
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
