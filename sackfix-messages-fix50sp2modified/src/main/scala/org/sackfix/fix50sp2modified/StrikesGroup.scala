package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class StrikesGroup(instrumentComponent:InstrumentComponent,
                        undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                        prevClosePxField:Option[PrevClosePxField]=None,
                        clOrdIDField:Option[ClOrdIDField]=None,
                        secondaryClOrdIDField:Option[SecondaryClOrdIDField]=None,
                        sideField:Option[SideField]=None,
                        priceField:Option[PriceField]=None,
                        currencyField:Option[CurrencyField]=None,
                        textField:Option[TextField]=None,
                        encodedTextLenField:Option[EncodedTextLenField]=None,
                        encodedTextField:Option[EncodedTextField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,instrumentComponent)
    undInstrmtGrpComponent.foreach(fmt(b,_))
    prevClosePxField.foreach(fmt(b,_))
    clOrdIDField.foreach(fmt(b,_))
    secondaryClOrdIDField.foreach(fmt(b,_))
    sideField.foreach(fmt(b,_))
    priceField.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object StrikesGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    PrevClosePxField.TagId, ClOrdIDField.TagId, SecondaryClOrdIDField.TagId, SideField.TagId, PriceField.TagId, 
    CurrencyField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrumentComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrumentComponent.isFieldOf(tagId) || UndInstrmtGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = InstrumentComponent.isFirstField(tagId) 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[StrikesGroup]=ArrayBuffer.empty[StrikesGroup]):Option[List[StrikesGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[StrikesGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[StrikesGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(StrikesGroup(InstrumentComponent.decode(flds, startPos).get,
          UndInstrmtGrpComponent.decode(flds, startPos),
          myFields.get(PrevClosePxField.TagId).flatMap(f=>PrevClosePxField.decode(f)),
          myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
          myFields.get(SecondaryClOrdIDField.TagId).flatMap(f=>SecondaryClOrdIDField.decode(f)),
          myFields.get(SideField.TagId).flatMap(f=>SideField.decode(f)),
          myFields.get(PriceField.TagId).flatMap(f=>PriceField.decode(f)),
          myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
          myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
          myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
          myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     