<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <Countries>
            <xsl:for-each select="//country[count(language) > 3]">
                <xsl:sort select="count(language)" order="descending" data-type="number"/>
                <!-- Trier en ordre décroissant -->
                <Country>
                    <xsl:attribute name="name">
                        <xsl:value-of select="@name"/>
                    </xsl:attribute>
                    <languages>
                        <xsl:value-of select="count(language)"/>
                    </languages>


                </Country>
            </xsl:for-each>
        </Countries>
    </xsl:template>
</xsl:stylesheet>