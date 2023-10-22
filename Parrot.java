//@Author: Sujan Rokad, 000882948
public class Parrot {

//    Introducing if-else conditions for 5 menu interface

//    For HIT interface
    public String hit() {
        String log = "";
        if (this.alive_dead == "alive") {
            if (this.health >= 1) {
                this.health -= 1;
                this.tamed_untamed = "untamed";
                this.flying_sitting = "flying";
                log = "Parrot is untamed now";
            }
            if (this.health == 0){
                this.alive_dead = "dead";

            }
        }
        else {
            this.health = 0;
            log = "parrot is already dead";

        }
        return log;
    }

//    for COMMAND interface
    public String command(String action) {
        String log="";
        if (this.alive_dead=="dead"){
            log="you can not command this parrot because it is dead";
        }
        else {
            if (this.tamed_untamed == "tamed"){
                if (action == "fly") {
                    this.flying_sitting = "flying";
                    log = "Wohoo, parrot is flying";
                } else {
                    this.flying_sitting = "stay";
                    log = "parrot stayed";
                }
            }
            else{
                log = "parrot is untamed and so cannot command";
            }

        }
        return log;
    }

//    for FEED interface
    public String feed(double food) {
        String log = "";
        if (this.alive_dead == "dead") {
            log = "You cannot feed this because it is dead";
        }
        else {

                this.health  = Math.min(this.health + 1, 3);
                this.crumbs += food;

                double prob = food * 20;
                if (prob >  50.0){
                    this.tamed_untamed = "tamed";
                }

            if (this.crumbs > 2.5) {
                this.health = Math.max(0, this.health - 2);

                if (this.health > 0){
                log = "parrot is sick";
                }

                if (this.health == 0){
                    this.alive_dead = "dead";
                    log = "dead";
                }
            }
            else {
                log = "Parrot has been fed";
            }

        }
        return log;
    }

//    for PLAY command
    public String play(Parrot p) {
        String log="";
        log = "Both parrots are busy enjoying their own company";
        if (this.tamed_untamed == "tamed" && p.getTamed_untamed() == "tamed"){
            this.tamed_untamed = "untamed";
            p.setTamed_untamed("untamed");
            return log;
        }
        else{
            log = "parrots are not tamed";
            return log;
        }



    }

//    Defining set and get method
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

        public double getCrumbs() {
        return crumbs;
    }

    public void setCrumbs(double crumbs) {
        this.crumbs = crumbs;
    }

    public String getTamed_untamed() {
        return tamed_untamed;
    }

    public void setTamed_untamed(String tamed_untamed) {
        this.tamed_untamed = tamed_untamed;
    }

    public String getAlive_dead() {
        return alive_dead;
    }

    public void setAlive_dead(String alive_dead) {
        this.alive_dead = alive_dead;
    }

    public String getFlying_sitting() {
        return flying_sitting;
    }

    public void setFlying_sitting(String flying_sitting) {
        this.flying_sitting = flying_sitting;
    }

//    Defining default parrot and its values
    String name = "Julius";
    int health = 3;
    double crumbs = 0.1;
    String tamed_untamed = "untamed";
    String alive_dead  = "alive";
    String flying_sitting = "flying";

//    toString() method to return values for the parrot

    public String toString() {
        return  "Name: " + this.name + " --- Health: " + this.health + " --- crumbs: " + this.crumbs + " --- Status: " + this.alive_dead + "..." + this.tamed_untamed + "..." + this.flying_sitting;
    }




}
