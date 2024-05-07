package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContextConfig {
    @Autowired
    private MemberDao memberDao;
    // 생성자 주입방식(spring 5부터 사용가능)
//    public ApplicationContextConfig(MemberDao memberDao){
//        this.memberDao = memberDao;
//    }

    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService registerService() {
        return new MemberRegisterService(memberDao());
    }

    @Bean
    public ChangePasswordService passwordService(){
        ChangePasswordService passwordService=new ChangePasswordService();
        passwordService.setMemberDao(memberDao());
        return passwordService;
    }

    @Bean
    public MemberPrinter memberPrinter(){
        return new MemberPrinter();
    }

    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter1(){
        return new MemberPrinter();
    }
    @Bean
    @Qualifier("summaryPrinter")
    public MemberSummaryPrinter memberPrinter2(){
        return new MemberSummaryPrinter();
    }

    @Bean
    public MemberListPrinter listPrinter(){
        return new MemberListPrinter();
    }

    @Bean
    public VersionPrinter versionPrinter(){
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }

    @Bean
    public MemberInfoPrinter memberInfoPrinter(){
        return new MemberInfoPrinter();
    }
}
