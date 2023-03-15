package myListTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class MyListTest {
    MyList myList;
    @BeforeEach
    void setUp(){
         myList = new MyList();
    }
    @Test
    void createNewListTest_isEmpty(){
        assertTrue(myList.isEmpty());
    }

    @Test
    void appendElement_isNotEmpty(){
        myList.append(12);
        assertFalse(myList.isEmpty());
    }

    @Test
    void removeEmptyElement_throwsEmptyListException(){
        assertThrows(MyList.EmptyListException.class, ()-> myList.remove());
    }

    @Test
    void appendElementX_removeElementX_isEmpty(){
        myList.append(12);
        myList.remove();
        assertTrue(myList.isEmpty());
    }

    @Test
    void addAnElementXtoIndexY_getElementXInIndexY_returnsY(){
        myList.add(0, 12);
        assertEquals(12, myList.getElement(0));
    }

    @Test
    void addAnElementXtoIndexY_removeElementXinIndexY_getElementInIndexY_returnsZero(){
        myList.add(0, 12);
        myList.remove(0);
        assertEquals(0, myList.getElement(0));
    }

    @Test
    void addAnElementsXandYtoIndexZ_remove_returnsX(){
        myList.append(10);
        myList.append(20);
        myList.remove();
        assertEquals(0, myList.getElement(1));
    }

    @Test
    void appendX_addYtoLastIndex_returnsY(){
        myList.append(10);
        myList.add(1, 20);
        assertEquals(20, myList.getElement(1));
    }

    @Test
    void addFourElements_appendX_overridesLastElement(){
        myList.add(0, 10);
        myList.add(1, 20);
        myList.add(2, 30);
        myList.add(3, 40);
        myList.append(50);
        assertEquals(50, myList.getElement(3));
    }
    @Test
    void addX_searchX_returnX(){
        myList.add(0, 10);
        myList.add(1, 20);
        myList.add(2, 30);
        assertEquals(30, myList.search(30));
    }

    @Test
    void searchForElementNotInList_returnNoElementFoundException(){
        assertThrows(MyList.NoElementFoundException.class, ()->myList.search(12));
    }

    @Test
    void getTheSizeOfElementsInTheList(){
        myList.append(10);
        myList.append(20);
        assertEquals(2, myList.getElementSize());
    }


}
