package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Optional;
@Component("printer")
public class MemberPrinter {
    private DateTimeFormatter dateTimeFormatter;

    @Autowired  //(required = false) //없으면 null, 있으면 추가됨
    public void setDateTimeFormatter(Optional<DateTimeFormatter> dateTimeFormatter) {
        dateTimeFormatter.ifPresent(dtf -> this.dateTimeFormatter = dtf);
    }

    public void print(Member member){
        if(dateTimeFormatter==null){
        System.out.printf(
                "회원 정보: 아이디=%d, 이메일=%s. 이름=%s. 등록일=%tF\n",
                member.getId(), member.getEmail(),
                member.getName(), member.getRegisterDateTime()
        );
        }else{
        System.out.printf(
                "회원 정보: 아이디=%d, 이메일=%s. 이름=%s. 등록일=%s\n",
                member.getId(), member.getEmail(),
                member.getName(), dateTimeFormatter.format(member.getRegisterDateTime())
        );

        }
    }
}
