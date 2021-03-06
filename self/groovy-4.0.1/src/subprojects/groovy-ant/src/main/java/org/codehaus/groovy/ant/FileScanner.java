/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.codehaus.groovy.ant;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileSet;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p><code>FileScanner</code> is a bean which allows the iteration
 * over a number of files from a collection of FileSet instances.
 */
public class FileScanner extends Task {

    private final List<FileSet> filesets = new ArrayList<>();

    public FileScanner() {
    }

    public FileScanner(final Project project) {
        setProject(project);
    }

    public Iterator<File> iterator() {
        return new FileIterator(getProject(), filesets.iterator());
    }

    public Iterator<File> directories() {
        return new FileIterator(getProject(), filesets.iterator(), true);
    }

    public boolean hasFiles() {
        return !filesets.isEmpty();
    }

    /**
     * Clears any file sets that have been added to this scanner
     */
    public void clear() {
        filesets.clear();
    }

    // Properties
    //-------------------------------------------------------------------------

    /**
     * Adds a set of files (nested fileset attribute).
     */
    public void addFileset(FileSet set) {
        filesets.add(set);
    }

}
