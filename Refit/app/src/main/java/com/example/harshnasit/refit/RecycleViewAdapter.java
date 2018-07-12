package com.example.harshnasit.refit;

//https://github.com/iPaulPro/Android-ItemTouchHelper-Demo/blob/master/app/src/main/java/co/paulburke/android/itemtouchhelperdemo/helper/ItemTouchHelperAdapter.java
public interface RecycleViewAdapter {
    boolean onItemMove(int fromPosition, int toPosition);

    boolean onItemDismiss(int position);

}
