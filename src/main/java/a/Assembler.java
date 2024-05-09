package a;

public class Assembler    {

    public MemberService memberService;
    public  MemberService2 memberService2;
    public MemberDao memberDao;

    public Assembler( ){
        memberDao = new MemberDaoMysql();
        this.memberService = new MemberService(memberDao);
        this.memberService2 = new MemberService2(memberDao);

    }
}
