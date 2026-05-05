<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">

        <Courses>
            <xsl:for-each select="//Department[Title='Electrical Engineering']/Course">

                <Course>
                    <xsl:attribute name="Number">
                        <xsl:value-of select="@Number"/>
                    </xsl:attribute>

                    <xsl:attribute name="Title">
                        <xsl:value-of select="Title"/>
                    </xsl:attribute>

                    <Description>
                        <xsl:value-of select="Description"/>
                    </Description>

                    <xsl:for-each select="Instructors/*">
                        <Instructor>
                            <xsl:value-of select="Last_Name"/>
                        </Instructor>
                    </xsl:for-each>

                </Course>

            </xsl:for-each>

        </Courses>

    </xsl:template>

</xsl:stylesheet>