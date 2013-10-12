package com.tjerkw.slideexpandable.library;

import android.view.View;
import android.widget.ListAdapter;

/**
 * ListAdapter that adds sliding functionality to a list. Uses
 * R.id.expandalbe_toggle_button and R.id.expandable id's if no ids are given in
 * the contructor.
 * 
 * @author tjerk
 * @date 6/13/12 8:04 AM
 */
public class SlideExpandableListAdapter extends AbstractSlideExpandableListAdapter {
    private final int toggle_button_id;
    private final int expandable_view_id;
    private final int expandable_view_type;

    public SlideExpandableListAdapter(ListAdapter wrapped, int toggle_button_id, int expandable_view_id,
            int expandable_view_type) {
        super(wrapped);
        this.toggle_button_id = toggle_button_id;
        this.expandable_view_id = expandable_view_id;
        this.expandable_view_type = expandable_view_type;
    }

    public SlideExpandableListAdapter(ListAdapter wrapped) {
        this(wrapped, R.id.expandable_toggle_button, R.id.expandable, 0);
    }

    @Override
    public View getExpandToggleButton(View parent) {
        return parent.findViewById(toggle_button_id);
    }

    @Override
    public View getExpandableView(View parent) {
        return parent.findViewById(expandable_view_id);
    }

    @Override
    protected boolean shouldBeExpandable(int position) {
        return expandable_view_type == getItemViewType(position);
    }
}
