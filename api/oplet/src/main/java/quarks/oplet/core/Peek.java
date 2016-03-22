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
package quarks.oplet.core;

/**
 * Oplet that allows a peek at each tuple and always forwards a tuple onto
 * its single output port.
 * 
 * {@link #peek(Object)} is called before the tuple is forwarded
 * and it is intended that the peek be a low cost operation
 * such as increasing a metric.
 *
 * @param <T>
 *            Type of the tuple.
 */
public abstract class Peek<T> extends Pipe<T, T> {
    private static final long serialVersionUID = 1L;

    @Override
    public final void accept(T tuple) {
        peek(tuple);
        submit(tuple);
    }

    protected abstract void peek(T tuple);
}
