package com.example.admin.DataBase

object AdminProfile {

    object AdminProfile {
        // Table contents are grouped together in an anonymous object.
        object AdminDetails : BaseColumns {
            const val TABLE_NAME = "AdminDetails"
            const val COLUMN_1 = "ItemId"
            const val COLUMN_2 = "ItemName"
            const val COLUMN_3 = "Itemprice"
            const val COLUMN_4 ="SupplierId"
        }
}