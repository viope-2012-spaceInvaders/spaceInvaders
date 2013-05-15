public class TestSpaceInvaders{
public static void main(String[] args) throws Exception {
BattleField bf = new BattleField("es-in.txt");
System.out.println("0st step :- "+bf);
for(int i=0; i<15; i++){
	bf.move();
	System.out.println((i+1)+"st step :- "+ bf);
}
bf.move();
System.out.println("2nd step :- "+bf);
bf.move();
System.out.println("3rd step :- "+bf);
bf.setBattleFieldElement(5,3,new GunShot(5,3));
bf.setBattleFieldElement(2,1,new AlienShot(2,1));
System.out.println("new entry:- "+bf);
bf.move();
System.out.println("4th step :- "+bf);
bf.move();
System.out.println("5th step :- "+bf);
bf.move();
bf.setFilename("es-out.txt");
bf.write();
System.out.println("out step :- "+bf);

}
}