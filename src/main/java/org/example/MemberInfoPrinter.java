package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
public class MemberInfoPrinter {
    private final MemberDao memDao;
    private final MemberPrinter printer;

    public MemberInfoPrinter(MemberDao memDao, @Qualifier("printer") MemberPrinter printer) {
        this.memDao = memDao;
        this.printer = printer;
    }

    //    public void setMemDao(MemberDao memDao) {
//        this.memDao = memDao;
//    }
//
//    public void setPrinter(MemberPrinter printer) {
//        this.printer = printer;
//    }
    public void printMemberInfo(String email) {
        Member member = memDao.selectByEmail(email);
        if (member == null) {
            System.out.println("데이터없음\n");
            return;
        }
        printer.setDateTimeFormatter(Optional.of(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")));
        printer.print(member);
        System.out.println();
    }
}
