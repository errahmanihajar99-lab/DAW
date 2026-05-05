<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <Countries>
            <xsl:for-each select="//country">
                <country>
                    -- Attributs
                    <xsl:attribute name="languages">
                        <xsl:value-of select="count(language)"/>
                    </xsl:attribute>
                    <xsl:attribute name="cities">
                        <xsl:value-of select="count(city)"/>
                    </xsl:attribute>

                    -- éléments
                    <Name>
                        <xsl:value-of select="@name"/>
                    </Name>
                    <Population>
                        <xsl:value-of select="@population"/>
                    </Population>
                    
                </country>
            </xsl:for-each>
        </Countries>
    </xsl:template>
</xsl:stylesheet>
