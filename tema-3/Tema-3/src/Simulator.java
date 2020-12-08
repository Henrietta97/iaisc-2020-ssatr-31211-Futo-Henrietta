import java.util.List;

    public class Simulator {
        Ports ports=new Ports();
        Capsules capsule=new Capsules();
        String name;
        List<Ports> portsin;
        List<Ports> portsout;

        public void getCapsule(){
            name=capsule.getName();
        }
        public List<String> getPortIn(){
            return capsule.getIn();
        }
        public List<String> getPortOut(){
            return capsule.getOut();
        }


        public static void checkTypePortsIn(){

        }
        public static void checkTypePortsOut(){

        }
        public static void main(String[] args){
            Caps_A capA = new Caps_A();
            Caps_B capB = new Caps_B();
            capA.msa.start();
            checkTypePortsIn();
        }

}
