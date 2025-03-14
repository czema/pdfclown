/*
  Copyright 2007-2012 Stefano Chizzolini. http://www.pdfclown.org

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

import java.util.List;

import org.pdfclown.PDF;
import org.pdfclown.VersionEnum;
import org.pdfclown.documents.contents.ContentScanner;
import org.pdfclown.documents.contents.LineJoinEnum;
import org.pdfclown.objects.PdfDirectObject;
import org.pdfclown.objects.PdfInteger;

/**
  'Set the line join style' operation [PDF:1.6:4.3.3].

  @author Stefano Chizzolini (http://www.stefanochizzolini.it)
  @since 0.0.4
  @version 0.1.2, 08/23/12
*/
@PDF(VersionEnum.PDF10)
public final class SetLineJoin
  extends Operation
{
  // <class>
  // <static>
  // <fields>
  public static final String Operator = "j";
  // </fields>
  // </static>

  // <dynamic>
  // <constructors>
  public SetLineJoin(
    LineJoinEnum value
    )
  {super(Operator, PdfInteger.get(value.getCode()));}

  public SetLineJoin(
    List<PdfDirectObject> operands
    )
  {super(Operator, operands);}
  // </constructors>

  // <interface>
  // <public>
  @Override
  public void scan(
    ContentScanner.GraphicsState state
    )
  {state.setLineJoin(getValue());}

  public LineJoinEnum getValue(
    )
  {
    return LineJoinEnum.valueOf(
      ((PdfInteger)operands.get(0)).getValue()
      );
  }

  public void setValue(
    LineJoinEnum value
    )
  {operands.set(0, PdfInteger.get(value.getCode()));}
  // </public>
  // </interface>
  // </dynamic>
  // </class>
}