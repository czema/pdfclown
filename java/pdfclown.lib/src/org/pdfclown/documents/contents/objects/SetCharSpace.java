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
import org.pdfclown.documents.contents.ContentScanner.GraphicsState;
import org.pdfclown.objects.PdfDirectObject;
import org.pdfclown.objects.PdfNumber;
import org.pdfclown.objects.PdfReal;

/**
  'Set the character spacing' operation [PDF:1.6:5.2].

  @author Stefano Chizzolini (http://www.stefanochizzolini.it)
  @since 0.0.4
  @version 0.1.2, 02/04/12
*/
@PDF(VersionEnum.PDF10)
public final class SetCharSpace
  extends Operation
{
  // <class>
  // <static>
  // <fields>
  public static final String Operator = "Tc";
  // </fields>
  // </static>

  // <dynamic>
  // <constructors>
  public SetCharSpace(
    double value
    )
  {super(Operator, PdfReal.get(value));}

  public SetCharSpace(
    List<PdfDirectObject> operands
    )
  {super(Operator, operands);}
  // </constructors>

  // <interface>
  // <public>
  @Override
  public void scan(
    GraphicsState state
    )
  {state.setCharSpace(getValue());}

  public double getValue(
    )
  {return ((PdfNumber<?>)operands.get(0)).getDoubleValue();}

  public void setValue(
    double value
    )
  {operands.set(0, PdfReal.get(value));}
  // </public>
  // </interface>
  // </dynamic>
  // </class>
}