<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <Countries>

            <xsl:for-each select="//country[not(@area > 40000) and not(city)]">

                <country>

                    <xsl:copy-of select="name"/>
                    <xsl:copy-of select="population"/>
                    <xsl:copy-of select="area"/>

                    <xsl:copy-of select="city"/>
                    <xsl:copy-of select="language"/>

                </country>

            </xsl:for-each>

        </Countries>
    </xsl:template>

</xsl:stylesheet>