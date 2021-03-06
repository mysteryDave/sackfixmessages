package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class QuoteSetsGroup(quoteSetIDField:QuoteSetIDField,
                          underlyingInstrumentComponent:Option[UnderlyingInstrumentComponent]=None,
                          quoteSetValidUntilTimeField:Option[QuoteSetValidUntilTimeField]=None,
                          totNoQuoteEntriesField:TotNoQuoteEntriesField,
                          lastFragmentField:Option[LastFragmentField]=None,
                          quotEntryGrpComponent:QuotEntryGrpComponent) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,quoteSetIDField)
    underlyingInstrumentComponent.foreach(fmt(b,_))
    quoteSetValidUntilTimeField.foreach(fmt(b,_))
    fmt(b,totNoQuoteEntriesField)
    lastFragmentField.foreach(fmt(b,_))
    fmt(b,quotEntryGrpComponent)
    b
  }

}
     
object QuoteSetsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int](
    QuoteSetIDField.TagId, TotNoQuoteEntriesField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    UnderlyingInstrumentComponent.isMandatoryField(tagId) || QuotEntryGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    QuoteSetValidUntilTimeField.TagId, LastFragmentField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    UnderlyingInstrumentComponent.isOptionalField(tagId) || QuotEntryGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    UnderlyingInstrumentComponent.isFieldOf(tagId) || QuotEntryGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==QuoteSetIDField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[QuoteSetsGroup]=ArrayBuffer.empty[QuoteSetsGroup]):Option[List[QuoteSetsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[QuoteSetsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[QuoteSetsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(QuoteSetsGroup(QuoteSetIDField.decode(myFields.get(QuoteSetIDField.TagId)).get,
          UnderlyingInstrumentComponent.decode(flds, startPos),
          myFields.get(QuoteSetValidUntilTimeField.TagId).flatMap(f=>QuoteSetValidUntilTimeField.decode(f)),
          TotNoQuoteEntriesField.decode(myFields.get(TotNoQuoteEntriesField.TagId)).get,
          myFields.get(LastFragmentField.TagId).flatMap(f=>LastFragmentField.decode(f)),
          QuotEntryGrpComponent.decode(flds, startPos).get)))
      } else (startPos, None)
    }
  }
    
}
     