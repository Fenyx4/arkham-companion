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
package com.example.fenyx4.navigationviewtest;

public class OtherWorldColor {

    private long colorID;
    private String colorName;
    private String buttonPath;
    private long expID;

    //DatabaseHelper.colorID,DatabaseHelper.colorName, DatabaseHelper.colorCardPath, DatabaseHelper.colorExpID};
    public OtherWorldColor(long colorID, String colorName, String buttonPath, long expID) {
        this.colorID = colorID;
        this.colorName = colorName;
        this.expID = expID;
        this.buttonPath = buttonPath;
    }

    public long getID() {
        return colorID;
    }

    public String getName() {
        return colorName;
    }

    public long getExpID() {
        return expID;
    }

    public String getButtonPath() {
        return buttonPath;
    }

    @Override public String toString()
    {
        return getName();
    }

    @Override
    public boolean equals(Object aThat) {
        //check for self-comparison
        if ( this == aThat ) return true;

        // instanceof checks for null already
        if ( !(aThat instanceof OtherWorldColor) ) return false;

        OtherWorldColor that = (OtherWorldColor)aThat;


        return colorID == that.getID();
    }

    @Override public int hashCode() {
        int result = 17;
        result = 31 * result + (int) (colorID ^ (colorID >>> 32));

        return result;
    }
}

