/**
 * Author:                 Sujan Rokad, 000882948
 * Authorship statement:   I, Sujan Rokad, 000882948, certify that this material is my original work.
 *                         No other person's work has been used without due acknowledgement.
 * Purpose:                Define a Parrot class and simulate interactions with parrots in ParrotCraft program.
 */

public class Parrot {

    // Properties of the Parrot class
    String name = "Julius";
    int health = 3;
    double crumbs = 0.1;
    String tamed_untamed = "untamed";
    String alive_dead = "alive";
    String flying_sitting = "flying";

    /**
     * Feed the parrot with the specified amount of food.
     *
     * @param food The amount of food to feed the parrot.
     * @return A log message indicating the result of the feeding.
     */
    public String feed(double food) {
        String log = "";

        // Check if the parrot is alive
        if (this.alive_dead == "dead") {
            log = "You cannot feed this because it is dead";
        } else {
            // Increase health and update crumbs based on the amount of food
            this.health = Math.min(this.health + 1, 3);
            this.crumbs += food;

            // Calculate probability to tame the parrot
            double prob = food * 20;
            if (prob > 50.0) {
                this.tamed_untamed = "tamed";
            }

            // Check if crumbs exceed a threshold
            if (this.crumbs > 2.5) {
                // Decrease health and update log if the parrot is sick
                this.health = Math.max(0, this.health - 2);
                if (this.health > 0) {
                    log = "Parrot is sick";
                }

                // Set the parrot as dead if health reaches 0
                if (this.health == 0) {
                    this.alive_dead = "dead";
                    log = "Parrot is dead";
                }
            } else {
                log = "Parrot has been fed";
            }
        }
        return log;
    }

    /**
     * Command the parrot to fly or stay.
     *
     * @param action The action to command the parrot.
     * @return A log message indicating the result of the command.
     */
    public String command(String action) {
        String log = "";
        if (this.alive_dead == "dead") {
            log = "You cannot command this parrot because it is dead";
        } else {
            if (this.tamed_untamed == "tamed") {
                // Command the tamed parrot to fly or stay
                if (action.equals("fly")) {
                    this.flying_sitting = "flying";
                    log = "Wohoo, parrot is flying";
                } else {
                    this.flying_sitting = "stay";
                    log = "Parrot stayed";
                }
            } else {
                log = "Parrot is untamed and cannot be commanded";
            }
        }
        return log;
    }

    /**
     * Simulate playing between two parrots.
     *
     * @param p The other parrot to play with.
     * @return A log message indicating the result of the play interaction.
     */
    public String play(Parrot p) {
        String log = "Both parrots are busy enjoying their own company";
        if (this.tamed_untamed.equals("tamed") && p.getTamed_untamed().equals("tamed")) {
            // Untame both parrots if they are tamed and try to play with each other
            this.tamed_untamed = "untamed";
            p.setTamed_untamed("untamed");
            return log;
        } else {
            log = "Parrots are not tamed";
            return log;
        }
    }

    // Getters and setters for the properties of the Parrot class

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

    /**
     * Override the toString() method to return the properties of the parrot.
     *
     * @return A string representation of the parrot's properties.
     */
    @Override
    public String toString() {
        return "Name: " + this.name + " --- Health: " + this.health + " --- Crumbs: " + this.crumbs +
               " --- Status: " + this.alive_dead + "..." + this.tamed_untamed + "..." + this.flying_sitting;
    }
}
