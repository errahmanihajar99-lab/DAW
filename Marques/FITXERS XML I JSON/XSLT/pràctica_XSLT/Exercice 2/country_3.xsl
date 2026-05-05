<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <Countries>
            <xsl:for-each select="//country[language[ends-with(., 'ian')]]">
            <!-- le point le texte de l’élément en cours -->
                <Country>
                   <Name>
                        <xsl:value-of select="@name"/>
                   </Name>
                   <Language>
                        <xsl:value-of select="language"/>
                   </Language>
                </Country>
            </xsl:for-each>
        </Countries>
    </xsl:template>
</xsl:stylesheet>