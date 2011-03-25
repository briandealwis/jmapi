/*
 * Copyright (C) 2004 Sun Microsystems, Inc. All rights reserved. Use is
 * subject to license terms.
 * Copyright (C) 2011 RPC Software LLC.  All rights reserved.  Use is 
 * subject to license terms
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA.
 */ 
package jmapi;

import java.io.IOException;

import org.jdesktop.jdic.desktop.internal.LaunchFailedException;
import org.jdesktop.jdic.desktop.internal.impl.WinAPIWrapper;
import org.jdesktop.jdic.desktop.internal.impl.WinMapiMailer;


public class JMAPI {
    /**
     * Check if the simple MAPI is supported in the current system.
     * 
     * @return true if simple MAPI is supported.
     */
    public static boolean isMapiSupported() {
        try {
            String regMapi =
                WinAPIWrapper.WinRegQueryValueEx(
                    WinAPIWrapper.HKEY_LOCAL_MACHINE,
                    "SOFTWARE\\Microsoft\\Windows Messaging Subsystem",
                    "MAPI");
            if(regMapi != null) {
                if(regMapi.equals("1")) {
                    return true;                
                }
            }
        } catch(UnsatisfiedLinkError e) {
        	e.printStackTrace();
            /* ignore */
        }
        return false;
    }

    /**
     * Open the provided message in the user's selected browser.
     * @param msg
     * @throws throws LaunchFailedException if the launching process failed 
     * @throws UnsatisfiedLinkError if the MAPI libraries cannot be loaded
     */
    public static void open(Message msg) throws LaunchFailedException {
        new WinMapiMailer().open(msg);        
    }
    
    /* not intended to be subclassed */
    private JMAPI() {}

	public static void open() throws LaunchFailedException {
        new WinMapiMailer().open();        		
	}
}
