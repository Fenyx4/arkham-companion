/*
 * This file is part of Arkham Companion.
 *
 *  Arkham Companion is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Arkham Companion is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Arkham Companion.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fenyx4.arkham.GUI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Gallery;

public class GalleryView extends Gallery {

	public GalleryView(Context context) {
		super(context);
	}
	
	public GalleryView(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
	}
	
	private boolean isScrollingLeft(MotionEvent e1, MotionEvent e2){
	    return e2.getX() > e1.getX();
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
	    int kEvent;
	    if(isScrollingLeft(e1, e2)){ //Check if scrolling left
	        kEvent = KeyEvent.KEYCODE_DPAD_LEFT;
	    }
	    else{ //Otherwise scrolling right
	        kEvent = KeyEvent.KEYCODE_DPAD_RIGHT;
	    }
	    onKeyDown(kEvent, null);
	    return true;  
	}

}
