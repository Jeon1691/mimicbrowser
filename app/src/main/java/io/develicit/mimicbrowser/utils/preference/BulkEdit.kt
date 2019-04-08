package io.develicit.mimicbrowser.utils.preference

import io.develicit.mimicbrowser.utils.preference.model.PrefModel


inline fun <T: PrefModel> T.bulk(block: T.() -> Unit) {
    beginBulkEdit()
    try {
        block()
    } catch (e: Exception) {
        cancelBulkEdit()
        throw e
    }
    commitBulkEdit()
}

inline fun <T: PrefModel> T.blockingBulk(block: T.() -> Unit) {
    beginBulkEdit()
    try {
        block()
    } catch (e: Exception) {
        cancelBulkEdit()
        throw e
    }
    blockingCommitBulkEdit()
}
