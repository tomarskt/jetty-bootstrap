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
package org.teknux.jettybootstrap.configuration;

import org.teknux.jettybootstrap.keystore.JettyKeystoreGeneratorBuilder;

import java.io.File;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
 * Base implementation of the configuration properties holding default values.
 */
public class JettyConfiguration implements IJettyConfiguration {

    private boolean autoJoinOnStart = true;

    private int maxThreads = 128;
    private boolean stopAtShutdown = true;
    private long stopTimeout = 5000;

    private long idleTimeout = 30000;
    private long blockingTimeout = -1;
    private String host = "0.0.0.0";
    private int port = 8080;
    private int sslPort = 8443;

    private Set<JettyConnector> jettyConnectors = new HashSet<>(Collections.singletonList(JettyConnector.HTTP));
    private boolean redirectWebAppsOnHttpsConnector = false;

    private JettySslFileFormat sslPrivateKeyFormat = JettySslFileFormat.PKCS8;
    private String sslPrivateKeyPath = null;
    private String sslPrivateKeyPassword = null;
    private JettySslFileFormat sslCertificateFormat = JettySslFileFormat.PKCS8;
    private String sslCertificatePath = null;
    private String sslCertificatePassword = null;
    private KeyStore sslKeyStore = null;
    private String sslKeyStorePath = null;
    private String sslKeyStoreDomainName = "unknown";
    private String sslKeyStoreAlias = "jettybootstrap";
    private String sslKeyStorePassword = "jettybootstrap";
    private String sslKeyStoreAlgorithm = JettyKeystoreGeneratorBuilder.DEFAULT_ALGORITHM;
    private String sslKeyStoreSignatureAlgorithm = JettyKeystoreGeneratorBuilder.DEFAULT_SIGNATURE_ALGORITHM;
    private String sslKeyStoreRdnOuValue = null;
    private String sslKeyStoreRdnOValue = null;
    private int sslKeyStoreDateNotBeforeNumberOfDays = JettyKeystoreGeneratorBuilder.DEFAULT_DATE_NOT_BEFORE_NUMBER_OF_DAYS;
    private int sslKeyStoreDateNotAfterNumberOfDays = JettyKeystoreGeneratorBuilder.DEFAULT_DATE_NOT_AFTER_NUMBER_OF_DAYS;

    private File tempDirectory = null;
    private boolean persistAppTempDirectories = false;
    private boolean cleanTempDir = false;
    private boolean parentLoaderPriority = true;
    private boolean throwIfStartupException = true;
    private int maxInactiveInterval = -1;

    public IJettyConfiguration clone() {
        try {
            return (IJettyConfiguration) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#isAutoJoinOnStart()
     */
    @Override
    public boolean isAutoJoinOnStart() {
        return autoJoinOnStart;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setAutoJoinOnStart(boolean)
     */
    @Override
    public void setAutoJoinOnStart(boolean autoJoinOnStart) {
        this.autoJoinOnStart = autoJoinOnStart;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getMaxThreads()
     */
    @Override
    public int getMaxThreads() {
        return maxThreads;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setMaxThreads(int)
     */
    @Override
    public void setMaxThreads(int maxThreads) {
        this.maxThreads = maxThreads;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#isStopAtShutdown()
     */
    @Override
    public boolean isStopAtShutdown() {
        return stopAtShutdown;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setStopAtShutdown(boolean)
     */
    @Override
    public void setStopAtShutdown(boolean stopAtShutdown) {
        this.stopAtShutdown = stopAtShutdown;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getStopTimeout()
     */
    @Override
    public long getStopTimeout() {
        return stopTimeout;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setStopTimeout(long)
     */
    @Override
    public void setStopTimeout(long stopTimeout) {
        this.stopTimeout = stopTimeout;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getIdleTimeout()
     */
    @Override
    public long getIdleTimeout() {
        return idleTimeout;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setIdleTimeout(long)
     */
    @Override
    public void setIdleTimeout(long idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getBlockingTimeout()
     */
    @Override
    public long getBlockingTimeout() {
        return blockingTimeout;

    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setBlockingTimeout(long)
     */
    @Override
    public void setBlockingTimeout(long blockingTimeout) {
        this.blockingTimeout = blockingTimeout;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getHost()
     */
    @Override
    public String getHost() {
        return host;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setHost(java.lang.String)
     */
    @Override
    public void setHost(String host) {
        this.host = host;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getPort()
     */
    @Override
    public int getPort() {
        return port;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setPort(int)
     */
    @Override
    public void setPort(int port) {
        this.port = port;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getSslPort()
     */
    @Override
    public int getSslPort() {
        return sslPort;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setSslPort(int)
     */
    @Override
    public void setSslPort(int sslPort) {
        this.sslPort = sslPort;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#hasJettyConnector(org.teknux.jettybootstrap.configuration.JettyConnector)
     */
    @Override
    public boolean hasJettyConnector(JettyConnector jettyConnector) {
        return (jettyConnectors.contains(jettyConnector));
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getJettyConnectors()
     */
    @Override
    public Set<JettyConnector> getJettyConnectors() {
        return jettyConnectors;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setJettyConnectors(org.teknux.jettybootstrap.configuration.JettyConnector[])
     */
    @Override
    public void setJettyConnectors(JettyConnector... jettyConnectors) {
        this.jettyConnectors = new HashSet<>(Arrays.asList(jettyConnectors));
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#isRedirectWebAppsOnHttpsConnector()
     */
    @Override
    public boolean isRedirectWebAppsOnHttpsConnector() {
        return redirectWebAppsOnHttpsConnector;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setRedirectWebAppsOnHttpsConnector(boolean)
     */
    @Override
    public void setRedirectWebAppsOnHttpsConnector(boolean redirectWebAppsOnHttpsConnector) {
        this.redirectWebAppsOnHttpsConnector = redirectWebAppsOnHttpsConnector;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getSslPrivateKeyFormat()
     */
    @Override
    public JettySslFileFormat getSslPrivateKeyFormat() {
        return sslPrivateKeyFormat;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setSslPrivateKeyFormat(org.teknux.jettybootstrap.configuration.JettySslFileFormat)
     */
    @Override
    public void setSslPrivateKeyFormat(JettySslFileFormat sslPrivateKeyFormat) {
        this.sslPrivateKeyFormat = sslPrivateKeyFormat;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getSslPrivateKeyPath()
     */
    @Override
    public String getSslPrivateKeyPath() {
        return sslPrivateKeyPath;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setSslPrivateKeyPath(java.lang.String)
     */
    @Override
    public void setSslPrivateKeyPath(String sslPrivateKeyPath) {
        this.sslPrivateKeyPath = sslPrivateKeyPath;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getSslPrivateKeyPassword()
     */
    @Override
    public String getSslPrivateKeyPassword() {
        return sslPrivateKeyPassword;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setSslPrivateKeyPassword(java.lang.String)
     */
    @Override
    public void setSslPrivateKeyPassword(String sslPrivateKeyPassword) {
        this.sslPrivateKeyPassword = sslPrivateKeyPassword;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getSslCertificateFormat()
     */
    @Override
    public JettySslFileFormat getSslCertificateFormat() {
        return sslCertificateFormat;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setSslCertificateFormat(org.teknux.jettybootstrap.configuration.JettySslFileFormat)
     */
    @Override
    public void setSslCertificateFormat(JettySslFileFormat sslCertificateFormat) {
        this.sslCertificateFormat = sslCertificateFormat;

    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getSslCertificatePath()
     */
    @Override
    public String getSslCertificatePath() {
        return sslCertificatePath;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setSslCertificatePath(java.lang.String)
     */
    @Override
    public void setSslCertificatePath(String sslCertificatePath) {
        this.sslCertificatePath = sslCertificatePath;
    }

    @Override
    public String getSslCertificatePassword() {
        return sslCertificatePassword;
    }

    @Override
    public void setSslCertificatePassword(String sslCertificatePassword) {
        this.sslCertificatePassword = sslCertificatePassword;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getSslKeyStore()
     */
    @Override
    public KeyStore getSslKeyStore() {
        return sslKeyStore;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setSslKeyStore(java.security.Keystore)
     */
    @Override
    public void setSslKeyStore(KeyStore sslKeyStore) {
        this.sslKeyStore = sslKeyStore;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getSslKeyStorePath()
     */
    @Override
    public String getSslKeyStorePath() {
        return sslKeyStorePath;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setSslKeyStorePath(java.lang.String)
     */
    @Override
    public void setSslKeyStorePath(String sslKeyStorePath) {
        this.sslKeyStorePath = sslKeyStorePath;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getSslKeyStoreDomainName()
     */
    @Override
    public String getSslKeyStoreDomainName() {
        return sslKeyStoreDomainName;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setSslKeyStoreDomainName(java.lang.String)
     */
    @Override
    public void setSslKeyStoreDomainName(String sslKeyStoreDomainName) {
        this.sslKeyStoreDomainName = sslKeyStoreDomainName;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getSslKeyStoreAlias()
     */
    @Override
    public String getSslKeyStoreAlias() {
        return sslKeyStoreAlias;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setSslKeyStoreAlias(java.lang.String)
     */
    @Override
    public void setSslKeyStoreAlias(String sslKeyStoreAlias) {
        this.sslKeyStoreAlias = sslKeyStoreAlias;

    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getSslKeyStorePassword()
     */
    @Override
    public String getSslKeyStorePassword() {
        return sslKeyStorePassword;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setSslKeyStorePassword(java.lang.String)
     */
    @Override
    public void setSslKeyStorePassword(String sslKeyStorePassword) {
        this.sslKeyStorePassword = sslKeyStorePassword;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getSslKeyStoreAlgorithm()
     */
    @Override
    public String getSslKeyStoreAlgorithm() {
        return sslKeyStoreAlgorithm;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setSslKeyStoreAlgorithm(java.lang.String)
     */
    @Override
    public void setSslKeyStoreAlgorithm(String sslKeyStoreAlgorithm) {
        this.sslKeyStoreAlgorithm = sslKeyStoreAlgorithm;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getSslKeyStoreSignatureAlgorithm()
     */
    @Override
    public String getSslKeyStoreSignatureAlgorithm() {
        return sslKeyStoreSignatureAlgorithm;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setSslKeyStoreSignatureAlgorithm(java.lang.String)
     */
    @Override
    public void setSslKeyStoreSignatureAlgorithm(String sslKeyStoreSignatureAlgorithm) {
        this.sslKeyStoreSignatureAlgorithm = sslKeyStoreSignatureAlgorithm;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getSslKeyStoreRdnOuValue()
     */
    @Override
    public String getSslKeyStoreRdnOuValue() {
        return sslKeyStoreRdnOuValue;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setSslKeyStoreRdnOuValue(java.lang.String)
     */
    @Override
    public void setSslKeyStoreRdnOuValue(String sslKeyStoreRdnOuValue) {
        this.sslKeyStoreRdnOuValue = sslKeyStoreRdnOuValue;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getSslKeyStoreRdnOValue()
     */
    @Override
    public String getSslKeyStoreRdnOValue() {
        return sslKeyStoreRdnOValue;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setSslKeyStoreRdnOValue(java.lang.String)
     */
    @Override
    public void setSslKeyStoreRdnOValue(String sslKeyStoreRdnOValue) {
        this.sslKeyStoreRdnOValue = sslKeyStoreRdnOValue;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getSslKeyStoreDateNotBeforeNumberOfDays()
     */
    @Override
    public int getSslKeyStoreDateNotBeforeNumberOfDays() {
        return sslKeyStoreDateNotBeforeNumberOfDays;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setSslKeyStoreDateNotBeforeNumberOfDays(int)
     */
    @Override
    public void setSslKeyStoreDateNotBeforeNumberOfDays(int sslKeyStoreDateNotBeforeNumberOfDays) {
        this.sslKeyStoreDateNotBeforeNumberOfDays = sslKeyStoreDateNotBeforeNumberOfDays;

    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getSslKeyStoreDateNotAfterNumberOfDays()
     */
    @Override
    public int getSslKeyStoreDateNotAfterNumberOfDays() {
        return sslKeyStoreDateNotAfterNumberOfDays;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setSslKeyStoreDateNotAfterNumberOfDays(int)
     */
    @Override
    public void setSslKeyStoreDateNotAfterNumberOfDays(int sslKeyStoreDateNotAfterNumberOfDays) {
        this.sslKeyStoreDateNotAfterNumberOfDays = sslKeyStoreDateNotAfterNumberOfDays;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getTempDirectory()
     */
    @Override
    public File getTempDirectory() {
        return tempDirectory;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setTempDirectory(java.io.File)
     */
    @Override
    public void setTempDirectory(File tempDirectory) {
        this.tempDirectory = tempDirectory;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#isPersistAppTempDirectories()
     */
    @Override
    public boolean isPersistAppTempDirectories() {
        return persistAppTempDirectories;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setPersistAppTempDirectories(boolean)
     */
    @Override
    public void setPersistAppTempDirectories(boolean persistAppTempDirectories) {
        this.persistAppTempDirectories = persistAppTempDirectories;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#isCleanTempDir()
     */
    @Override
    public boolean isCleanTempDir() {
        return cleanTempDir;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setCleanTempDir(boolean)
     */
    @Override
    public void setCleanTempDir(boolean cleanTempDir) {
        this.cleanTempDir = cleanTempDir;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#isParentLoaderPriority()
     */
    @Override
    public boolean isParentLoaderPriority() {
        return parentLoaderPriority;
    }

    /* (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setParentLoaderPriority(boolean)
     */
    @Override
    public void setParentLoaderPriority(boolean parentLoaderPriority) {
        this.parentLoaderPriority = parentLoaderPriority;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#isThrowIfStartupException()
     */
    @Override
    public boolean isThrowIfStartupException() {
        return throwIfStartupException;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setThrowIfStartupException(boolean)
     */
    @Override
    public void setThrowIfStartupException(boolean throwIfStartupException) {
        this.throwIfStartupException = throwIfStartupException;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#getMaxInactiveInterval()
     */
    @Override
    public int getMaxInactiveInterval() {
        return maxInactiveInterval;
    }

    /*
     * (non-Javadoc)
     * @see org.teknux.jettybootstrap.configuration.IJettyConfiguration#setMaxInactiveInterval(int)
     */
    @Override
    public void setMaxInactiveInterval(int maxInactiveInterval) {
        this.maxInactiveInterval = maxInactiveInterval;
    }

    @Override
    public String toString() {
        return "JettyConfiguration [autoJoinOnStart=" + autoJoinOnStart + ", maxThreads=" + maxThreads + ", stopAtShutdown=" + stopAtShutdown + ", stopTimeout=" + stopTimeout +
            ", idleTimeout=" + idleTimeout + ", host=" + host + ", port=" + port + ", sslPort=" + sslPort + ", jettyConnectors=" + jettyConnectors +
            ", redirectWebAppsOnHttpsConnector=" + redirectWebAppsOnHttpsConnector + ", sslPrivateKeyFormat=" + sslPrivateKeyFormat + ", sslPrivateKeyPath=" + sslPrivateKeyPath +
            ", sslCertificateFormat=" + sslCertificateFormat + ", sslCertificatePath=" + sslCertificatePath + ", sslKeyStorePath=" + sslKeyStorePath + ", sslKeyStoreDomainName=" +
            sslKeyStoreDomainName + ", sslKeyStoreAlias=" + sslKeyStoreAlias + ", sslKeyStorePassword=" + sslKeyStorePassword + ", sslKeyStoreAlgorithm=" + sslKeyStoreAlgorithm +
            ", sslKeyStoreSignatureAlgorithm=" + sslKeyStoreSignatureAlgorithm + ", sslKeyStoreRdnOuValue=" + sslKeyStoreRdnOuValue + ", sslKeyStoreRdnOValue=" +
            sslKeyStoreRdnOValue + ", sslKeyStoreDateNotBeforeNumberOfDays=" + sslKeyStoreDateNotBeforeNumberOfDays + ", sslKeyStoreDateNotAfterNumberOfDays=" +
            sslKeyStoreDateNotAfterNumberOfDays + ", tempDirectory=" + tempDirectory + ", persistAppTempDirectories=" + persistAppTempDirectories + ", cleanTempDir=" +
            cleanTempDir + ", parentLoaderPriority=" + parentLoaderPriority + ", throwIfStartupException=" + throwIfStartupException + ", maxInactiveInterval=" +
            maxInactiveInterval + "]";
    }
}
