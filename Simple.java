import java.util.*; //for array


/**
 * A mutable object that maintains state. Components of state include textual data, numerical data,
 * logical data, and an infinite-length sequence of integers.  The parameters to the constructor establish
 * the initial state of the object including the characteristics of the numerical sequence.
 * @version Fall 2018 v1.0.2
 * @author Jackie Nugent
 */




public class Simple extends Object{
    /** The text status of this object*/
    String text;
    /** The numerical data of this object*/
    Number number;
    /** The numerical data of this object*/
    Boolean truth;
    //initial values of the sequence
    Integer[] initVals;
    //after all initial values have been exhausted, the number of previous (historical) values
    //added together to calculate the next value of the sequence
    int depth;

    /**
     * Constructs a Simple object using arbitrary values.
     */
    public Simple(){

        this(" ", 1, true, new Integer[]{1,2,3}, 0);
    }

    /** Constructs a Simple object initialized to the specified values and sequence definition.<br><br>
     * @param text the textual data
     * @param number the numerical data
     * @param truth the logical data
     * @param initVals the initial values of the sequence
     * @param depth after all initial values have been exhausted, the number of previous (historical) values added together to calculate the next value of the sequence
     */

    public Simple(String text, Number number, Boolean truth, Integer[] initVals, int depth){
        this.text = text;
        this.number = number;
        this.truth = truth;
        this.initVals = initVals;
        this.depth = depth;

    }
    /**
     * Accesses the logical component of state.
     * @return the truth status
     */
    public Boolean truth(){

        return this.truth;
    }

    /**
     * Accesses the textual component of state.
     * @return the text status
     */
    public String text(){

        return this.text;
    }

    /**
     * Accesses the numerical component of state.
     * @return the numeric status
     */
    public Number number(){

        return this.number;
    }

    /**
     * Modifies the state by inverting the logical value. If the logical state was true, it is changed to false.
     * If the logical state was false, it is changed to true.
     */
    public void flip(){

        this.truth = !truth;

    }

    /**
     * Renders Simple object in the format: Simple[truth, number, "text"]
     */
    @Override
    public String toString(){

        return "Simple[" +truth+ ", " +number+ ", " +text+ "]";
    }

    /**
     * Accesses items of the sequence, in order, beginning with the initial values passed into the constructor.
     * The first invocation returns the initial element of the sequence specified by the parameter to the constructor.
     * Modifies state so that the subsequent invocation will return the following item of the sequence.
     * @return the item in the sequence corresponding to the number of times the method has been invoked
     */

    public Integer nextInSequence(){


        Integer newVals = 0;
        if(depth <= initVals.length){
            for(int i = 1; i < depth + 1; i++){
                newVals = newVals + initVals[initVals.length - i];
            }
            initVals = Arrays.copyOf(initVals, initVals.length + 1);
            initVals[initVals.length - 1] = newVals;
        }else if(initVals.length == 0){ //empty sequence
            newVals = 0;
        }
        else{
            //the behavior of sequences for which depth is greater than number of the initial values is unspecified
            //decided to just have it return the last element in the sequence
            newVals = initVals[initVals.length - 1];
        }
        return newVals;
    }

    //Main method for testing purposes
    /*
    public static void main (String[] args){

        Simple obj = new Simple();
        Simple obj2 = new Simple("Hello World", 42, false, new Integer[]{5, 4, 3, 2, 1}, 6 );

        System.out.println(obj.toString());
        System.out.println(obj2.toString());

        System.out.println(obj.truth);
        System.out.println(obj2.truth);
        obj.flip();
        obj2.flip();
        System.out.println("FLIP:");
        System.out.println(obj.truth);
        System.out.println(obj2.truth);

        System.out.println(obj.text);
        System.out.println(obj2.text);

        System.out.println(obj.number());
        System.out.println(obj2.number);

        System.out.println(obj.depth);

        System.out.println(obj.nextInSequence());
        System.out.println(obj2.nextInSequence());
        System.out.println(obj2.nextInSequence());
        System.out.println(obj2.nextInSequence());

    }
    */
}