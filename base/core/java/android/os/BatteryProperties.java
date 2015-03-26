/* Copyright 2013, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package android.os;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * {@hide}
 */
public class BatteryProperties implements Parcelable {
    public boolean chargerAcOnline;
    public boolean chargerUsbOnline;
    public boolean chargerWirelessOnline;
    public int batteryStatus;
    public int batteryStatus_2nd;
    public int batteryHealth;
    public boolean batteryPresent;
    public boolean batteryPresent_2nd;
    public int batteryLevel;
    public int batteryLevel_2nd;
    public int batteryVoltage;
    public int batteryCurrentNow;
    public int batteryChargeCounter;
    public int batteryTemperature;
    public String batteryTechnology;

    /*
     * Parcel read/write code must be kept in sync with
     * frameworks/native/services/batteryservice/BatteryProperties.cpp
     */

    private BatteryProperties(Parcel p) {
        chargerAcOnline = p.readInt() == 1 ? true : false;
        chargerUsbOnline = p.readInt() == 1 ? true : false;
        chargerWirelessOnline = p.readInt() == 1 ? true : false;
        batteryStatus = p.readInt();
        batteryStatus_2nd = p.readInt();
        batteryHealth = p.readInt();
        batteryPresent = p.readInt() == 1 ? true : false;
        batteryPresent_2nd = p.readInt() == 1 ? true : false;
        batteryLevel = p.readInt();
        batteryLevel_2nd = p.readInt();
        batteryVoltage = p.readInt();
        batteryCurrentNow = p.readInt();
        batteryChargeCounter = p.readInt();
        batteryTemperature = p.readInt();
        batteryTechnology = p.readString();
    }

    public void writeToParcel(Parcel p, int flags) {
        p.writeInt(chargerAcOnline ? 1 : 0);
        p.writeInt(chargerUsbOnline ? 1 : 0);
        p.writeInt(chargerWirelessOnline ? 1 : 0);
        p.writeInt(batteryStatus);
        p.writeInt(batteryStatus_2nd);
        p.writeInt(batteryHealth);
        p.writeInt(batteryPresent ? 1 : 0);
        p.writeInt(batteryPresent_2nd ? 1 : 0);
        p.writeInt(batteryLevel);
        p.writeInt(batteryLevel_2nd);
        p.writeInt(batteryVoltage);
        p.writeInt(batteryCurrentNow);
        p.writeInt(batteryChargeCounter);
        p.writeInt(batteryTemperature);
        p.writeString(batteryTechnology);
    }

    public static final Parcelable.Creator<BatteryProperties> CREATOR
        = new Parcelable.Creator<BatteryProperties>() {
        public BatteryProperties createFromParcel(Parcel p) {
            return new BatteryProperties(p);
        }

        public BatteryProperties[] newArray(int size) {
            return new BatteryProperties[size];
        }
    };

    public int describeContents() {
        return 0;
    }
}
