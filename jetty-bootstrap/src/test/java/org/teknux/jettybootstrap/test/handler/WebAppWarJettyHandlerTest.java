/*******************************************************************************
 * (C) Copyright 2014 Teknux.org (http://teknux.org/).
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
 *  
 * Contributors:
 *      "Pierre PINON"
 *      "Francois EYL"
 *      "Laurent MARCHAL"
 *  
 *******************************************************************************/
package org.teknux.jettybootstrap.test.handler;

import java.io.File;
import java.io.IOException;

import org.eclipse.jetty.server.Handler;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runners.MethodSorters;
import org.teknux.jettybootstrap.JettyBootstrapException;
import org.teknux.jettybootstrap.handler.WarAppJettyHandler;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WebAppWarJettyHandlerTest {

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Test
	public void do01WebAppWarJettyHandlerTest() throws JettyBootstrapException, IOException {

		File tempDir = temporaryFolder.newFolder();
		WarAppJettyHandler webAppWarJettyHandler = new WarAppJettyHandler();
		webAppWarJettyHandler.setContextPath("myContext");
		webAppWarJettyHandler.setTempDirectory(tempDir);
		webAppWarJettyHandler.setWar("/tmp/myWarFile.war");
		webAppWarJettyHandler.setPersistTempDirectory(false);
		webAppWarJettyHandler.setParentLoaderPriority(true);

		Handler handler = webAppWarJettyHandler.getHandler();

		Assert.assertEquals("WebAppContext", handler.getClass().getSimpleName());
	}
}