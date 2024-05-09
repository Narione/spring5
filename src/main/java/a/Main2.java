package a;

public class Main2 {

    public static void main(String[] args) {

        Assembler assembler=new Assembler();


        MemberDao memberDao=assembler.memberDao;
        MemberService memberService=assembler.memberService;
        MemberService2 memberService2=assembler.memberService2;

    }
}
