package com.infinitechnic.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IoUtil {
	/**
	 * This function retrieves files under the specific folder, it will recursively retrieve if the 'recursive' flag is 'true'.
	 *
	 * @param folder      the folder
	 * @param recursive   the recursive
	 * @param level       no. of level that the function will retrieve (0 means current directory only, -1 means until end of folder structure)
	 * @return A list of File objects
	 * @see java.io.File
	 */
	private static final List<File> listFilesForFolder(final File folder, final boolean recursive, final int level) {
		List<File> files = new ArrayList<File>();

		if (folder.isDirectory()) {
			for (final File fileEntry : folder.listFiles()) {
				if (fileEntry.isDirectory() && recursive && (level == -1 || level > 0)) {
					files.addAll(listFilesForFolder(fileEntry, recursive, level==-1?-1:level-1));
				} else if (!fileEntry.isDirectory()) {
					files.add(fileEntry);
				}
			}
		}
	    
	    return files;
	}

	/**
	 * This function retrieves files under the specific folder, it will recursively retrieve until end of folder structure if the 'recursive' flag is 'true'.
	 *
	 * @param folder    the folder
	 * @param recursive the recursive
	 * @return A list of File objects
	 * @see java.io.File
	 */
	public static final List<File> listFilesForFolder(final File folder, final boolean recursive) {
		return listFilesForFolder(folder, recursive, -1);
	}

	/**
	 * This function retrieves files recursively with no. of level under the specific folder.
	 *
	 * @param folder the folder
	 * @param level  the level
	 * @return A list of File objects
	 * @see java.io.File
	 */
	public static final List<File> listFilesForFolder(final File folder, final int level) {
		return listFilesForFolder(folder, true, level);
	}
}
