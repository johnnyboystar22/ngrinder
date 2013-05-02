/* 
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.ngrinder.common.util;

import org.apache.commons.lang.StringUtils;

/**
 * Utility class for path manipulation.
 * 
 * @author JunHo Yoon
 * @since 3.0
 * 
 */
public abstract class PathUtil {

	public static final int MAX_PATH_LENGTH = 40;

	/**
	 * Remove prepending / on path.
	 * 
	 * @param path
	 *            path containning /
	 * @return / removed path
	 */
	public static String removePrependedSlash(String path) {
		if (path.startsWith("/")) {
			return path.substring(1);
		}
		return path;
	}

	/**
	 * Remove prepending / on path.
	 * 
	 * @param path
	 *            path containning /
	 * @return / removed path
	 */
	public static String removeDuplicatedPrependedSlash(String path) {
		if (path.startsWith("//")) {
			return path.substring(1);
		}
		return path;
	}

	/**
	 * Get short path because actual path is too long to display it totally.
	 * 
	 * @param path
	 *            path
	 * 
	 * @return shortPath
	 */
	public static String getShortPath(String path) {
		if (path.length() >= MAX_PATH_LENGTH && StringUtils.contains(path, "/")) {
			String start = path.substring(0, path.indexOf("/") + 1);
			String end = path.substring(path.lastIndexOf("/"), path.length());
			return start + "..." + end;
		} else {
			return path;
		}
	}
}
