package coding;

import javassist.runtime.Inner;
import lombok.Data;
import lombok.Getter;


@Data
public class DeepClone implements Cloneable  {
    private Integer id ;
    private String name;
    private Float f;
    private InnerObj innerObj;
    private Object o ;



    public static void main(String[] args) throws CloneNotSupportedException {
        DeepClone o1 = new DeepClone();
        o1.setId(1);
        o1.setName("n");
        InnerObj in = new InnerObj();
        in.setOther(2);
        o1.setInnerObj(in);
        DeepClone o2 =  (DeepClone) o1.clone();
        o1.getInnerObj().setOther(3);
        System.out.println(o1.getName() + " " + o1.getId() + " " + o1.getInnerObj().getOther());
        System.out.println(o2.getName() + " " + o2.getId() + " " + o2.getInnerObj().getOther());
    }



//        @Override
//    public DeepClone clone() {
//        try {
//            DeepClone clone = (DeepClone) super.clone();
//            // TODO: copy mutable state here, so the clone can't change the internals of the original
//            return clone;
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }

    @Override
    public DeepClone clone() {
        try {
            DeepClone clone = (DeepClone) super.clone();
            InnerObj innerClone = clone.getInnerObj().clone();
            clone.setInnerObj(innerClone);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
@Getter
class InnerObj implements Cloneable {
    private Integer other;

    public void setOther(Integer other) {
        this.other = other;
    }

        @Override
    protected InnerObj clone() throws CloneNotSupportedException {
        return (InnerObj) super.clone();
    }
}
