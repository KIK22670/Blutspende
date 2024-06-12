package com.example.blutspendekompabilitaetsapp

import org.junit.Assert.assertEquals
import org.junit.Test

class MainActivityTest {

    private val mainActivity = MainActivity()

    @Test
    fun testGetCompatibleBloodTypes() {
        assertEquals("A+, A-, O+, O-", mainActivity.getCompatibleBloodTypes("A+"))
        assertEquals("A-, O-", mainActivity.getCompatibleBloodTypes("A-"))
        assertEquals("B+, B-, O+, O-", mainActivity.getCompatibleBloodTypes("B+"))
        assertEquals("B-, O-", mainActivity.getCompatibleBloodTypes("B-"))
        assertEquals("Alle Blutgruppen", mainActivity.getCompatibleBloodTypes("AB+"))
        assertEquals("AB-, A-, B-, O-", mainActivity.getCompatibleBloodTypes("AB-"))
        assertEquals("O+, O-", mainActivity.getCompatibleBloodTypes("O+"))
        assertEquals("O-", mainActivity.getCompatibleBloodTypes("O-"))
    }
}