/*
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
# Copyright IBM Corp. 2015, 2016 
*/
package quarks.oplet.functional;


import static quarks.function.Functions.closeFunction;

import quarks.function.Consumer;

/**
 * Functional peek oplet.
 * 
 * Each peek calls {@code peeker.accept(tuple)}.
 *
 * @param <T> Tuple type.
 */
public class Peek<T> extends quarks.oplet.core.Peek<T> {
    private static final long serialVersionUID = 1L;
    private final Consumer<T> peeker;

    /**
     * Peek oplet using a function to peek.
     * @param peeker Function that peeks at the tuple.
     */
    public Peek(Consumer<T> peeker) {
        this.peeker = peeker;
    }

    @Override
    protected void peek(T tuple) {
        peeker.accept(tuple);
    }

    @Override
    public void close() throws Exception {
        closeFunction(peeker);
    }
}
