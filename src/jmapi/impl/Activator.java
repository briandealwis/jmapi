/*
 * Copyright (C) 2011 RPC Software LLC. All rights reserved. Use is
 * subject to license terms.
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
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA.
 */
package jmapi.impl;

import org.jdesktop.jdic.desktop.internal.impl.WinAPIWrapper;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
    public void start(BundleContext context) throws Exception {
    	// didn't think this was required with Bundle-NativeCode
        try {
            System.loadLibrary("jdic");
        } catch(UnsatisfiedLinkError e) {
            // this is ok
        }
    }

    public void stop(BundleContext context) throws Exception {
        WinAPIWrapper.shutDown();
    }
}
