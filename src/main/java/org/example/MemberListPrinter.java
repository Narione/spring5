package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;
@Component
public class MemberListPrinter {
    private final MemberDao memberDao;
    private final MemberPrinter printer;


    public MemberListPrinter(MemberDao memberDao, MemberSummaryPrinter printer) {
        this.memberDao = memberDao;
        this.printer = printer;
    }

    //    public MemberListPrinter(){};
//
//    public MemberListPrinter(MemberDao memberDao, MemberPrinter printer){
//        this.memberDao = memberDao;
//        this.printer = printer;
//    }
// 세터에도 붙이지만 보통 필드에 붙임
//    @Autowired
//    public void setMemberDao(MemberDao memberDao) {
//        this.memberDao = memberDao;
//    }
//    @Autowired
//    @Qualifier("summaryPrinter")
//    public void setPrinter(MemberPrinter printer) {
//        this.printer = printer;
//    }




    public void printAll() {
        Collection<Member>members = memberDao.selectAll();
        // method reference : 람다식보다 더 축약된 방식
//        members.forEach(m->printer.print(m));
        members.forEach(printer::print);
    }
}
