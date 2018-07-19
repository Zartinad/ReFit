package com.example.harshnasit.refit.WorkoutCreation;

//https://github.com/iPaulPro/Android-ItemTouchHelper-Demo/blob/master/app/src/main/java/co/paulburke/android/itemtouchhelperdemo/helper/ItemTouchHelperAdapter.java
public interface RecycleViewAdapter {
    boolean onItemMove(int fromPosition, int toPosition);

    boolean onItemDismiss(int position);

}
