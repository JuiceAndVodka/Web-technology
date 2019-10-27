package bean;

import java.util.ArrayList;
import java.util.Random;

public class Identifier {

    private int Id;

    public int getId()
    {
        return Id;
    }

    public void setId(int id)
    {
        Id = id;
    }

    public static boolean isIdUniq(int id, ArrayList<Identifier> identifierList)
    {
        for(Identifier identifier: identifierList)
        {
            if (identifier.getId() == id) {
                return false;
            }
        }
        return true;
    }

    public static int getUniqId(ArrayList<Identifier> identifierList)
    {
        Random random = new Random(System.currentTimeMillis());
        boolean isIdUniq;
        int uniqId;

        do {
            isIdUniq = true;
            uniqId = random.nextInt();

            for (Identifier identifier : identifierList) {
                if (identifier.getId() == uniqId) {
                    isIdUniq = false;
                }
            }
        }while (isIdUniq);

        return uniqId;
    }
}
