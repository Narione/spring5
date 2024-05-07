package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class MemberInfoPrinter {
    @Autowired
    private MemberDao memDao;
    @Autowired
    @Qualifier("printer")
    private MemberPrinter printer;

    /*
        public void printMemberInfo(String email){
            Member member = memDao.selectByEmail(email);
            if(member == null){
                System.out.println("데이터 없음\n");
                return;
            }
            printer.print(member);
            System.out.println();
        }
    */
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
