/*
  Copyright 2007-2011 Stefano Chizzolini. http://www.pdfclown.org

  Contributors:
    * Stefano Chizzolini (original code developer, http://www.stefanochizzolini.it)

  This file should be part of the source code distribution of "PDF Clown library"
  (the Program): see the accompanying README files for more info.

  This Program is free software; you can redistribute it and/or modify it under the terms
  of the GNU Lesser General Public License as published by the Free Software Foundation;
  either version 3 of the License, or (at your option) any later version.

  This Program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY,
  either expressed or implied; without even the implied warranty of MERCHANTABILITY or
  FITNESS FOR A PARTICULAR PURPOSE. See the License for more details.

  You should have received a copy of the GNU Lesser General Public License along with this
  Program (see README files); if not, go to the GNU website (http://www.gnu.org/licenses/).

  Redistribution and use, with or without modification, are permitted provided that such
  redistributions retain the above copyright notice, license and disclaimer, along with
  this list of conditions.
*/

package org.pdfclown.documents.contents.objects;

import org.pdfclown.PDF;
import org.pdfclown.VersionEnum;
import org.pdfclown.bytes.IBuffer;
import org.pdfclown.bytes.IOutputStream;
import org.pdfclown.documents.Document;

/**
  Inline image data (anonymous) operation [PDF:1.6:4.8.6].
  <p>This is a figurative operation necessary to constrain the inline image data section
  within the content stream model.</p>

  @author Stefano Chizzolini (http://www.stefanochizzolini.it)
  @since 0.0.4
  @version 0.1.1, 11/01/11
*/
@PDF(VersionEnum.PDF10)
public final class InlineImageBody
  extends Operation
{
  // <class>
  // <static>
  // <fields>
  private IBuffer value;
  // </fields>
  // </static>

  // <dynamic>
  // <constructors>
  public InlineImageBody(
    IBuffer value
    )
  {
    super(null);

    this.value = value;
  }
  // </constructors>

  // <interface>
  // <public>
  public IBuffer getValue(
    )
  {return value;}

  /**
    @since 0.0.6
  */
  public void setValue(
    IBuffer value
    )
  {this.value = value;}

  @Override
  public void writeTo(
    IOutputStream stream,
    Document context
    )
  {stream.write(value);}
  // </public>
  // </interface>
  // </dynamic>
  // </class>
}