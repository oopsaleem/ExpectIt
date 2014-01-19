package net.sf.expectit.filter;

/*
 * #%L
 * net.sf.expectit
 * %%
 * Copyright (C) 2014 Alexey Gavrilov
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

/**
 * A default filter implementation which does not modify the input. It is intended to be used for creating subclasses.
 */
public class FilterAdapter implements Filter {
    private boolean off;
    /**
     * The protected default constructor.
     */
    protected FilterAdapter() {
    }

    @Override
    public final String beforeAppend(String string, StringBuilder buffer) {
        if (off) {
            return string;
        }
        return doBeforeAppend(string, buffer);
    }

    /**
     * Called if the filter is ON. Follows the contract of the {@link #beforeAppend(String, StringBuilder)}
     * method.
     *
     * @param string the input string
     * @param buffer the input buffer
     * @return the result
     */
    protected String doBeforeAppend(String string, StringBuilder buffer) {
        return string;
    }

    @Override
    public final boolean afterAppend(StringBuilder buffer) {
        return !off && doAfterAppend(buffer);
    }

    /**
     * Called if the filter is ON. Follows the contract of the {@link #afterAppend(StringBuilder)} method.
     *
     * @param buffer the input buffer
     * @return the results
     */
    protected boolean doAfterAppend(StringBuilder buffer) {
        return false;
    }

    @Override
    public final boolean isOff() {
        return off;
    }

    @Override
    public final void setOff(boolean off) {
       this.off = off;
    }
}
